-- checking before the qurrey

SELECT * FROM EMPLOYEES ;


-- qurrey to create a procedure

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id     IN NUMBER,
    p_percent    IN NUMBER
) AS
    v_old_salary Employees.Salary%TYPE;
BEGIN
    -- Get current salary
    SELECT Salary INTO v_old_salary
    FROM Employees
    WHERE EmployeeID = p_emp_id;

    -- Update salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_emp_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Salary for Employee ID ' || p_emp_id || 
        ' updated from ₹' || v_old_salary || 
        ' to ₹' || (v_old_salary + (v_old_salary * p_percent / 100))
    );

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_emp_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/


-- running procedure
EXEC UpdateSalary(2, 10);   -- Bob Brown gets a 10% hike
EXEC UpdateSalary(999, 5);  -- ID doesn't exist → handled


-- checking after the qurrey

SELECT * FROM EMPLOYEES ;
