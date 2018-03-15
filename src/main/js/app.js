'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {stations: [], hasError: false};
    }

    componentDidMount() {
        client({method: 'GET', path: '/stations'}).done(response => {
            if (response.entity.status < 200 || response.entity.status >= 300) {
                this.setState({hasError: true});
            } else {
                this.setState({stations: response.entity});
            }
        });
    }

    render() {
        if (this.state.hasError) {
            return (<h3 style={{color: 'red'}}>Kunne ikke hent data fra server. Det har skjedd en uventet feil.</h3>)
        }
        return (
            <StationList stations={this.state.stations}/>
        )
    }
}

class StationList extends React.Component {
    render() {
        var stations = this.props.stations.map(station =>
            <Station key={station.id} station={station}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Navn</th>
                    <th>Beskrivelse</th>
                    <th>Tilgjengelige låser</th>
                    <th>Ledige sykler</th>
                </tr>
                {stations}
                </tbody>
            </table>
        )
    }
}

class Station extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.station.title}</td>
                <td>{this.props.station.subtitle}</td>
                <td>{this.props.station.availability.locks}</td>
                <td>{this.props.station.availability.bikes}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('render-container')
)
