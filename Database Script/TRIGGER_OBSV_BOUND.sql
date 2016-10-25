create or replace TRIGGER obsv_value_bound
  BEFORE
    INSERT-- OR
    --UPDATE OF ob_value
  ON observation
FOR EACH ROW
declare is_null number;
lo_bound number;
up_bound number;
alert_count number;
descrip_reco VARCHAR2(1024);
BEGIN
select R1.lower_bound into is_null from RECOMMENDATION R1 where R1.r_id = :new.r_id;
--if (select R1.lower_bound from RECOMMENDATION R1 where R1.r_id = :new.r_id) <> NULL
--if :new.r_id <> null
if is_null is not null
  then
    select to_number(R1.lower_bound) into lo_bound from RECOMMENDATION R1 where R1.r_id = :new.r_id;
    select to_number(R1.upper_bound) into up_bound from RECOMMENDATION R1 where R1.r_id = :new.r_id;
    select R1.description into descrip_reco from RECOMMENDATION R1 where R1.r_id = :new.r_id;
    if (to_number(:new.ob_value) > up_bound or to_number(:new.ob_value) < lo_bound)
      then
      select count(*) into alert_count from alert;
      insert into alert values(alert_count+1,1, descrip_reco, 'False');
       --DBMS_OUTPUT.PUT_LINE('InsertingYY');
       --select R1.lower_bound from RECOMMENDATION R1 where R1.r_id = :new.r_id;
       else
       --DBMS_OUTPUT.PUT_LINE('InsertingNNN');
    end if;
end if;
END;
/



COMMIT;
