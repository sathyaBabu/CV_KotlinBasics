package ParticipantsCode

/*
SELECT column_list {FROM table};




SELECT column_list FROM table;

SELECT * FROM table_name;
// *   table_name   (INPUTS expected from you )


SELECT tbl_name FROM sqlite_master WHERE type = 'table';

SELECT sql FROM sqlite_master WHERE type = 'table' AND tbl_name = 'COMPANY';

CREATE TABLE COMPANY(
ID INT PRIMARY KEY     NOT NULL,
NAME           TEXT    NOT NULL,
AGE            INT     NOT NULL,
ADDRESS        CHAR(50),
SALARY         REAL
)
*/
//
class select(val Select :String){
    infix fun FROM (table: List<Int>){
        println(" $Select column_List FROM $table")
    }
}

infix fun String.column_list(function: select.() ->Unit){
    println("callled the column_list")
    select(this).function()
}

// sathyahelp123@gmail.com
// sellect * FROM student_table
// create table   .......



fun main(){

    "SELECT" column_list {
        FROM (listOf(1,2))
    }
    /// s: String = "SELECT" "*"

}