# March 4, 2023 
SQL --> Structured Query Language

- Became a Standard of ANSI(American National Standards Institute) in 1986 and of ISO(International Organisation for 
Standardization) in 1987

- There are different versions of SQL but they all must contain major commands(such as SELECT, UPDATE, DELETE, INSERT, WHERE) to be compliant with the ANSI standard

- Northwind database is a sample used by Microsoft to demonstrate the features of some its products, including SQL Server and Microsoft Access.

- *Records - Rows*, *Fields - Columns*

- SQL keywords are NOT case sensitive: **select** is the same as **SELECT**

- **Semicolon[;]** is the standard way to separate each SQL statement in database systems.


### SELECT Statement
Syntax:
: *SELECT column1, column2, ...*
  *FROM table_name;*

  **SELECT DISTINCT column_name** -  Used to select the distinct record(value) in a database table

  **SELECT COUNT(DISTINCT column_name)** - Used to count the number of distinct record values. !Not supported in MS Access.
  
  Use the following workaround:
    **SELECT Count(*) AS new_column_name**
    **FROM (SELECT DISTINCT column_name FROM table_name);**


