import React, { Component } from 'react';
import logo from './logo.svg';
import axios from 'axios';
import './App.css';
import { Table, Button, Row, Col, Container } from 'reactstrap';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      vehicles: null,
      manufacturer: "",
      model: "",
      vin: "",
      type: ""
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    this.fetchVehicles();
  }

  fetchVehicles() {
    fetch("http://localhost:8080/list")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            vehicles: result
          });
        },
        (error) => {
          alert(error.message);
        }
      )
  }

  setVehicleState(no, status) {
    axios.post(`http://localhost:8080/set-state/${no}/${status}`, {
    })
      .then((response) => {
        this.fetchVehicles();
      }, (error) => {
        alert(error.response.data.message);
      });
  }

  delete(no) {
    axios.post(`http://localhost:8080/delete/${no}`, {
    })
      .then((response) => {
        this.fetchVehicles();
      }, (error) => {
      });
  }

  handleChange(event) {
    this.setState({[event.target.name]: event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();

    var item = {};
    item.manufacturer = this.state.manufacturer;
    item.model = this.state.model;
    item.vin = this.state.vin;
    item.type = this.state.type;
    
    axios.post(`http://localhost:8080/create/`, item)
      .then((response) => {
        this.setState({
          manufacturer : "",
          model: "",
          vin: "",
          type: ""
        })
        this.fetchVehicles();
      }, (error) => {
        alert(error.response.data.message);
      });
    
  }

  render() {
    return (
      <Container fluid className="App">
        <h1>WYPOŻYCZALNIA POJAZDÓW</h1>
        <Row>
          <Col lg="10">
            <div style={{
            overflowY: 'auto'
          }}>
            <Table striped hover>
              <thead>
                <tr>
                  <th>Lp.</th>
                  <th>Producent</th>
                  <th>Model</th>
                  <th>VIN</th>
                  <th>Typ</th>
                  <th>Stan</th>
                  <th>Akcja</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                {this.state.vehicles == null ? null : this.state.vehicles.map((data, index) => {
                  return [
                    <tr key={index}>
                      <td>{index}</td>
                      <td>{data.manufacturerModel.manufacturer}</td>
                      <td>{data.manufacturerModel.model}</td>
                      <td>{data.vin}</td>
                      <td>{data.type.name}</td>
                      <td>{data.state.state.name}</td>
                      <td><Button color="primary" size="sm" onClick={() => this.setVehicleState(index, 'FREE')} >WOLNY</Button>
                        <Button color="secondary" size="sm" onClick={() => this.setVehicleState(index, 'BORROWED')} >WYPOŻ.</Button>
                        <Button color="success" size="sm" onClick={() => this.setVehicleState(index, 'WASHING')} >MYJNIA</Button>
                        <Button color="info" size="sm" onClick={() => this.setVehicleState(index, 'REPAIRING')} >WARSZTAT</Button>
                        <Button color="warning" size="sm" onClick={() => this.setVehicleState(index, 'DAMAGED')} >USZKODZONY</Button>
                        <Button color="danger" size="sm" onClick={() => this.setVehicleState(index, 'DISPOSED')} >ZEZŁOM.</Button></td>
                        <td><Button size="sm" onClick={() => this.delete(index)} >Usuń</Button></td>
                    </tr>
                  ]

                })}

              </tbody>

            </Table>
            </div>
          </Col>
          <Col lg="2" >
            <form class="form-horizontal" onSubmit={this.handleSubmit}>
              <div class="form-group">
                <div class="col-lg-6">Producent:</div>
                <div class="col-lg-6"><input name="manufacturer" value={this.state.manufacturer} onChange={this.handleChange} required/></div>
              </div>
              <div class="form-group">
                <div class="col-lg-6">Model:</div>
                <div class="col-lg-6"><input name="model" onChange={this.handleChange} value={this.state.model} required/></div>
              </div>
              <div class="form-group">
                <div class="col-lg-6">VIN:</div>
                <div class="col-lg-6"><input name="vin" onChange={this.handleChange} value={this.state.vin} required/></div>
              </div>
              <div class="form-group">
                <div class="col-lg-6">Typ:</div>
                <div class="col-lg-6"><select name="type" onChange={this.handleChange} value={this.state.type} required>
                  <option></option>
                  <option value='CAR'>Osobowy</option>
                  <option value='MOTORCYCLE'>Motocykl</option>
                  <option value='BUS'>Autobus</option>
                  <option value='TRACTOR'>Traktor</option>
                </select></div>
              </div>

              <input type="submit" value="Dodaj" />
            </form>
          </Col>
        </Row>
      </Container>
    );
  }

}

export default App;
