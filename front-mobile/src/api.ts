import axios from 'axios';

// esse ip veio da tela do expo
//const API_URL = 'http://192.168.15.20:19000:8080';

const API_URL = 'https://deliverypizza-biacoelho.herokuapp.com';

export function fetchOrders() {
  return axios(`${API_URL}/orders`);
}

export function confirmDelivery(orderId: number) {
  return axios.put(`${API_URL}/orders/${orderId}/delivered`);
}