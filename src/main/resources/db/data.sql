-- Insert test data into Books
INSERT INTO books (title, author_name, genre, year_published) VALUES
                                                                ('To Kill a Mockingbird', 'Harper Lee', 'FICTION', 1960),
                                                                ('1984', 'George Orwell', 'FICTION', 1949),
                                                                ('The Great Gatsby', 'F. Scott Fitzgerald', 'FICTION', 1925),
                                                                ('A Brief History of Time', 'Stephen Hawking', 'NON_FICTION', 1988),
                                                                ('The Iliad', 'Homer', 'POETRY', -750);

-- Insert test data into Readers
INSERT INTO readers (reader_name, reader_phone, registration_date, email) VALUES
                                                                           ('John Doe', '1234567890', '2024-01-01', 'johndoe@example.com'),
                                                                           ('Jane Smith', '0987654321', '2023-06-15', 'janesmith@example.com'),
                                                                           ('Alice Johnson', '1112223333', '2024-02-20', 'alice.johnson@example.com'),
                                                                           ('Bob Brown', '5556667777', '2023-12-01', 'bob.brown@example.com'),
                                                                           ('Emma Davis', '8889990000', '2024-03-10', 'emma.davis@example.com');

-- Insert test data into Loans
INSERT INTO loans (reader_id, book_id, loan_date, return_date) VALUES
                                                               (1, 1, '2024-01-15', '2024-01-22'),  -- John Doe borrowed "To Kill a Mockingbird"
                                                               (2, 2, '2024-01-10', NULL),          -- Jane Smith borrowed "1984", not yet returned
                                                               (3, 3, '2024-02-01', '2024-02-14'),  -- Alice Johnson borrowed "The Great Gatsby"
                                                               (4, 4, '2024-01-25', NULL),          -- Bob Brown borrowed "A Brief History of Time"
                                                               (5, 5, '2024-03-15', '2024-03-20');  -- Emma Davis borrowed "The Iliad"
