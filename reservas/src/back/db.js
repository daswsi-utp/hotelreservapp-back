const mysql = require('mysql2');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'tu_usuario',
  password: 'tu_contraseña',
  database: 'bd_hotel'
});

connection.connect(err => {
  if (err) throw err;
  console.log('Conectado a MySQL');
});

module.exports = connection;
