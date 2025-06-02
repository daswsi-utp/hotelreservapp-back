const express = require('express');
const router = express.Router();
const pool = require('../db');  // pool mysql2


// GET /api/bookings?search=Juan&status=confirmed&page=1&limit=10
router.get('/', async (req, res) => {
  try {
    const { search = '', status = 'all', page = 1, limit = 10 } = req.query;
    const offset = (page - 1) * limit;

    // create where
    let whereClauses = [];
    let params = [];

    if (search) {
      whereClauses.push(
        `(guestName LIKE ? OR guestEmail LIKE ? OR roomName LIKE ?)`
      );
      const likeSearch = `%${search}%`;
      params.push(likeSearch, likeSearch, likeSearch);
    }

    if (status && status !== 'all') {
      whereClauses.push(`status = ?`);
      params.push(status);
    }

    // coincidence
    const where = whereClauses.length ? 'WHERE ' + whereClauses.join(' AND ') : '';

    // order
    const [bookings] = await pool.execute(
      `SELECT * FROM bookings ${where} ORDER BY id DESC LIMIT ? OFFSET ?`,
      [...params, parseInt(limit), parseInt(offset)]
    );

    // count reg
    const [countResult] = await pool.execute(
      `SELECT COUNT(*) as total FROM bookings ${where}`,
      params
    );

    const total = countResult[0].total;
    const totalPages = Math.ceil(total / limit);

    res.json({
      bookings,
      total,
      page: parseInt(page),
      totalPages,
    });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Server error' });
  }
});

// POST /api/bookings - newrevervation
router.post('/', async (req, res) => {
  try {
    const { guestName, guestEmail, roomName, checkIn, checkOut, totalPrice, status } = req.body;

    const [result] = await pool.execute(
      `INSERT INTO bookings (guestName, guestEmail, roomName, checkIn, checkOut, totalPrice, status) VALUES (?, ?, ?, ?, ?, ?, ?)`,
      [guestName, guestEmail, roomName, checkIn, checkOut, totalPrice, status || 'pending']
    );

    // back data
    const [rows] = await pool.execute(`SELECT * FROM bookings WHERE id = ?`, [result.insertId]);

    res.status(201).json(rows[0]);
  } catch (err) {
    console.error(err);
    res.status(400).json({ error: err.message });
  }
});

module.exports = router;
