create or replace TRIGGER delete_well_person AFTER
    INSERT ON sick_person
    FOR EACH ROW
BEGIN
    DELETE FROM well_person WHERE
        p_id =:new.p_id;
    COMMIT;
END;
/
