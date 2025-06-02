const mongoose = require('mongoose');

const bookingSchema = new mongoose.Schema({
  guestName: String,
  guestEmail: String,
  roomName: String,
  checkIn: Date,
  checkOut: Date,
  totalPrice: Number,
  status: { type: String, enum: ['confirmed', 'pending', 'cancelled'], default: 'pending' },
});

module.exports = mongoose.model('Booking', bookingSchema);
