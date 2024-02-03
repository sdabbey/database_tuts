import sqlite3

class StudentDatabase:
    def __init__(self, db_name):
        self.conn = sqlite3.connect(db_name)
        self.create_table()

    def create_table(self):
        # Creating a 'students' table with columns 'id', 'name', and 'age'
        query = '''
        CREATE TABLE IF NOT EXISTS students (
            id INTEGER PRIMARY KEY,
            name TEXT NOT NULL,
            age INTEGER
        )
        '''
        self.conn.execute(query)

    def add_student(self, name, age):
        # Inserting a new student into the 'students' table
        query = 'INSERT INTO students (name, age) VALUES (?, ?)'
        self.conn.execute(query, (name, age))
        self.conn.commit()

    def get_students(self):
        # Retrieving all students from the 'students' table
        query = 'SELECT id, name, age FROM students'
        cursor = self.conn.execute(query)
        return cursor.fetchall()

# Creating an instance of the StudentDatabase class
db = StudentDatabase('example.db')

# Adding students to the database
db.add_student('Alice', 20)
db.add_student('Bob', 22)

# Retrieving and displaying students from the database
students = db.get_students()
print("Students:")
for student in students:
    print(f"ID: {student[0]}, Name: {student[1]}, Age: {student[2]}")
