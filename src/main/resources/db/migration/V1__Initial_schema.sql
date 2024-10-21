CREATE TABLE items (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       category VARCHAR(50),
                       price DECIMAL(10, 2) NOT NULL,
                       stock_quantity INT NOT NULL,
                       low_stock_threshold INT NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for tracking sales
CREATE TABLE sales (
                       id SERIAL PRIMARY KEY,
                       item_id INT REFERENCES items(id) ON DELETE CASCADE,
                       quantity_sold INT NOT NULL,
                       total_price DECIMAL(10, 2) NOT NULL,
                       sold_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for storing users
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,  -- e.g., Admin, Employee
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for restocking requests
CREATE TABLE restocking_requests (
                                     id SERIAL PRIMARY KEY,
                                     item_id INT REFERENCES items(id) ON DELETE CASCADE,
                                     requested_quantity INT NOT NULL,
                                     request_status VARCHAR(50) DEFAULT 'Pending',
                                     requested_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);