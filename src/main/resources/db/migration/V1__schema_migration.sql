CREATE TABLE Payment (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         amount DECIMAL(10,2) NOT NULL,
                         status VARCHAR(50) NOT NULL
);

CREATE TABLE Reservation (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             payment_id INT NOT NULL,
                             amount DECIMAL(10,2) NOT NULL,
                             status VARCHAR(50) NOT NULL,
                             FOREIGN KEY (payment_id) REFERENCES Payment(id)
);



