-- Insert test data into Payment table
INSERT INTO Payment (amount, status) VALUES (100.00, 'Paid');
INSERT INTO Payment (amount, status) VALUES (50.00, 'Pending');
INSERT INTO Payment (amount, status) VALUES (75.00, 'Paid');
INSERT INTO Payment (amount, status) VALUES (120.00, 'Pending');

-- Insert test data into Reservation table
INSERT INTO Reservation (payment_id, amount, status) VALUES (1, 80.00, 'Confirmed');
INSERT INTO Reservation (payment_id, amount, status) VALUES (2, 40.00, 'Pending');
INSERT INTO Reservation (payment_id, amount, status) VALUES (3, 60.00, 'Confirmed');
INSERT INTO Reservation (payment_id, amount, status) VALUES (4, 100.00, 'Pending');





