# March 4, 2023 
**SQL -- Structured Query Language**

- Became a Standard of ANSI(American National Standards Institute) in 1986 and of ISO(International Organisation for 
Standardization) in 1987.

- There are different versions of SQL but they all must contain major commands(such as SELECT, UPDATE, DELETE, INSERT, WHERE) to be compliant with the ANSI standard.

- Northwind database is a sample used by Microsoft to demonstrate the features of some its products, including SQL Server and Microsoft Access.

- *Records - Rows*, *Fields - Columns*

- SQL keywords are NOT case sensitive: **select** is the same as **SELECT**

- **Semicolon[;]** is the standard way to separate each SQL statement in database systems.


### SELECT Statement
- Used to select data from a database
Syntax
: *SELECT column1, column2, ...*
  *FROM table_name;*

  **SELECT DISTINCT column_name** -  Used to select the distinct record(value) in a database table.

  **SELECT COUNT(DISTINCT column_name)** - Used to count the number of distinct record values.
  (!Not supported in MS Access.)
  
  Use the following workaround:
    **SELECT Count(*) AS new_column_name**
    **FROM (SELECT DISTINCT column_name FROM table_name);**


### WHERE Clause
- Used to filter records
Syntax
: *SELECT column1, column2, ...*
  *FROM table_name*
  *WHERE condition;* - Example: *WHERE Country='Sweden';* "Country='Sweden' is the condition.
  - Uses all comparison operators
  - Special Operators: *BETWEEN*, *LIKE*, *IN*
  (!Used in UPDATE, DELETE, etc)


### ORDER BY Clause
- Used to sort the result-set in ascending or descending order.
Syntax
: *SELECT column1, column2, ...*
  *FROM table_name*
  *ORDER BY column1, column2, ... ASC|DESC;*

---


# March 5, 2023 
### AND Operator
- The *WHERE* Clause can contain one or many *AND* operators.
Syntax
: *SELECT column1, column2, ...*
  *FROM table_name*
  *WHERE condition1 AND condition2 AND condition3 ...;*

- Can combine the *AND* and *OR* operators.


### OR Operator
- The *WHERE* Clause can contain one or many *OR* operators.
Syntax
: *SELECT column1, column2, ...*
  *FROM table_name*
  *WHERE condition1 OR condition2 OR condition3 ...;*

### NOT Operator
- Used in combination with other operators to give the opposite result(Negative result)
Syntax
: *SELECT column1, column2, ...*
  *FROM table_name*
  *WHERE NOT condition;*

  **NOT Operator and Other Operators**
  - NOT LIKE, NOT BETWEEN, NOT IN, NOT Greater Than(NOT >), NOT Less Than(NOT < or !<(just that))

---


# March 6, 2023 
### INSERT INTO Statement
- Used to insert new records in a table
- Can write the INSERT INTO statement in two ways
  1. Used to specify both the columns and values for each. 
  *INSERT INTO table_name(column1, column2, column3, ...)*
  *VALUES (value1, value2, value3, ...)*
  
  2. Used when adding values for all the columns. Make sure the order of the values match that of the columns. 
  *INSERT INTO table_name*
  *VALUES (value1, value2, value3, ...)*

- To insert multiple rows, comma[,] is used to separate each set of values.
  example: **INSERT INTO Customer (CustomerName, 'Address')**
           **VALUES** 
           **('james', 'plot 35 blk A'),**
           **('Mark', 'Chico 10 blk B');**



### NULL Value
- A field with a NULL value is a field with no value.
- We use *IS NULL* AND *IS NOT NULL* operators to test for null values.

*IS NULL Syntax*
  **SELECT column_names**
  **FROM table_name**
  **WHERE column_name IS NULL;**

*IS NOT NULL Syntax*
  **SELECT column_names**
  **FROM table_name**
  **WHERE column_name is NOT NULL;**