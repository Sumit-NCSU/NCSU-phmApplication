--List the number of health supporters that were authorized in the month of September 2016 by patients suffering from heart disease.
select count(*)
from sick_person
where (P_ID in (select P_ID from RECORD_DISEASE where D_ID in (select D_ID from Disease where UPPER(DNAME) = 'HEART DISEASE'))) 
      and (to_char(hs1_auth_date,'MM') = '09' or to_char(hs2_auth_date, 'MM')= '09');




--Give the number of patients who were not complying with the recommended frequency of recording observations.
--define dateToCheckForFrequency = 23
define dateToCheckForFrequency = to_number(to_char(sysdate, 'DD'))

select SP1.p_id, R1.r_id, to_char(RO1.ob_time) as Took_On, R1.description, concat((to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)), substr(to_char(RO1.ob_time), 3,25) ) as Had_To_Take_Next_On
from  sick_person SP1, STANDARD_RECOMMENDATION SR1,  RECORD_DISEASE RD1, RECOMMENDATION R1, OBSERVATION O1, RECORD_OBSERVATION RO1
where SP1.p_id = RD1.p_id and RD1.d_id = SR1.d_id and R1.r_id = SR1.r_id and O1.r_id = R1.r_id and RO1.ob_id = O1.ob_id and RO1.p_id = SP1.p_id and 
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) < &dateToCheckForFrequency and
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) <> any (
select to_number(to_char(RO2.ob_time, 'DD'))
from  STANDARD_RECOMMENDATION SR2, OBSERVATION O2, RECORD_OBSERVATION RO2
where RD1.d_id = SR2.d_id and R1.r_id = SR2.r_id and O2.r_id = R1.r_id and RO2.ob_id = O2.ob_id and RO2.p_id = SP1.p_id)

union 

select SP1.p_id, R1.r_id, to_char(RO1.ob_time) as Took_On, R1.description, concat((to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)), substr(to_char(RO1.ob_time), 3,25) ) as Had_To_Take_Next_On
from  sick_person SP1, SPECIFIC_RECOMMENDATION SPR1, RECOMMENDATION R1, OBSERVATION O1, RECORD_OBSERVATION RO1
where SP1.p_id = SPR1.p_id and R1.r_id = SPR1.r_id and O1.r_id = R1.r_id and RO1.ob_id = O1.ob_id and RO1.p_id = SP1.p_id and 
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) < &dateToCheckForFrequency and
(to_number(to_char(RO1.ob_time, 'DD')) + to_number(R1.frequency)) <> any (
select to_number(to_char(RO2.ob_time, 'DD'))
from  SPECIFIC_RECOMMENDATION SPR2, OBSERVATION O2, RECORD_OBSERVATION RO2
where R1.r_id = SPR2.r_id and O2.r_id = R1.r_id and RO2.ob_id = O2.ob_id and RO2.p_id = SP1.p_id);





--    List the health supporters who themselves are patients.
select SP1.p_id, P.pname
from sick_person SP1, sick_person SP2, person P
where (SP1.p_id = SP2.HS1_ID or SP1.p_id = SP2.HS2_ID) and SP1.p_id = P.p_id;






--    List the patients who are not ‘sick’.
select * 
from PERSON
where P_ID not in (select P_ID from SICK_PERSON);






--    How many patients have different observation time and recording time (of the observation).
select count(P_ID)
from RECORD_OBSERVATION
where (RECORD_TIME <> OB_TIME);