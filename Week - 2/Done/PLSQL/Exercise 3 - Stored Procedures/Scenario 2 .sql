-- checking before the qurrey

SELECT * FROM EMPLOYEES ;


-- qurrey to create a procedure

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department   IN VARCHAR2,
    p_bonus_pct    IN NUMBER
) AS
    v_old_salary Employees.Salary%TYPE;
    v_new_salary Employees.Salary%TYPE;
BEGIN
    FOR rec IN (
        SELECT EmployeeID, Name, Salary
        FROM Employees
        WHERE Department = p_department
        FOR UPDATE
    ) LOOP
        v_old_salary := rec.Salary;
        v_new_salary := rec.Salary + (rec.Salary * p_bonus_pct / 100);

        UPDATE Employees
        SET Salary = v_new_salary
        WHERE EmployeeID = rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE(
            'Bonus applied to ' || rec.Name || ' (ID: ' || rec.EmployeeID || 
            ') in ' || p_department || ' - Old: ₹' || v_old_salary || ', New: ₹' || v_new_salary
        );
    END LOOP;

    COMMIT;
END;
/


-- running procedure

EXEC UpdateEmployeeBonus('IT', 10);



-- checking after the qurrey

SELECT * FROM EMPLOYEES ;
