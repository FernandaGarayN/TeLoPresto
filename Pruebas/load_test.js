import http from 'k6/http';
import {sleep} from 'k6';

// Para ejecutar el test de carga es necesario instalar k6 y luego ejecutar este archivo con k6 run ./load_test.js

export let options = {
    insecureSkipTLSVerify: true,
    noConnectionReuse: false,
    vus: 200,
    duration: '60s'
}

export default () => {
    const url = 'http://localhost:8080/'

    http.get(url)
}