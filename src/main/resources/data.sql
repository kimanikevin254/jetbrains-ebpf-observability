-- Only seed if tables are empty
INSERT INTO customers (name, email)
SELECT * FROM (VALUES
    ('Alice Smith', 'alice@example.com'),
    ('Brian Johnson', 'brian@example.com'),
    ('Clara Brown', 'clara@example.com')
) AS v(name, email)
WHERE NOT EXISTS (SELECT 1 FROM customers LIMIT 1);

INSERT INTO orders (customer_id, product, amount, created_at)
SELECT * FROM (VALUES
    (1, 'Laptop',  1200.00, NOW()),
    (1, 'Mouse',     25.00, NOW()),
    (2, 'Keyboard',  75.00, NOW()),
    (3, 'Monitor',  300.00, NOW()),
    (3, 'Webcam',    50.00, NOW())
) AS v(customer_id, product, amount, created_at)
WHERE NOT EXISTS (SELECT 1 FROM orders LIMIT 1);