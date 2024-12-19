drop table if exists loans;
drop table if exists readers;
drop table if exists books;
CREATE TABLE books (
                      book_id INT PRIMARY KEY AUTO_INCREMENT, -- Primary Key
                      title VARCHAR(255) ,           -- Title of the book
                      author_name VARCHAR(255),      -- Name of the author
                      genre  VARCHAR(32) , -- Genre as ENUM
                      year_published INT                      -- Year of publication
);

-- Table for Readers
CREATE TABLE readers (
                        reader_id INT PRIMARY KEY AUTO_INCREMENT, -- Primary Key
                        reader_name VARCHAR(255) ,        -- Name of the reader
                        reader_phone VARCHAR(15),                 -- Phone number of the reader
                        registration_date DATE ,          -- Registration date
                        email VARCHAR(255)                       -- Email of the reader
);

-- Table for Loans
CREATE TABLE loans (
                      loan_id INT PRIMARY KEY AUTO_INCREMENT,   -- Primary Key
                      reader_id INT ,                   -- Foreign Key to Reader
                      book_id INT ,                     -- Foreign Key to Book
                      loan_date DATE ,                  -- Date when book was loaned
                      return_date DATE,                         -- Date when book was returned
                      FOREIGN KEY (reader_id) REFERENCES readers(reader_id), -- Reader relationship
                      FOREIGN KEY (book_id) REFERENCES books(book_id)        -- Book relationship
);