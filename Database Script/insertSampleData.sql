--Person
insert into Person values(1, 'Sheldon Cooper', null, 'password', ' 2500 Sacramento, Apt 903, Santa Cruz, CA - 90021', to_date('19840526','YYYYMMDD'),'M');
insert into Person values(2, 'Leonard Hofstader', null, 'password', ' 2500 Sacramento, Apt 904, Santa Cruz, CA - 90021', to_date('19890419','YYYYMMDD'),'M');
insert into Person values(3, 'Penny Hofstader', null, 'password', ' 2500 Sacramento, Apt 904, Santa Cruz, CA - 90021', to_date('19901225','YYYYMMDD'),'F');
insert into Person values(4, 'Amy Farrahfowler', null, 'password', ' 2500 Sacramento, Apt 905, Santa Cruz, CA - 90021', to_date('19920615','YYYYMMDD'),'F');


--Sick Person
insert into SICK_PERSON values(1, 2, 4, to_date('20161021','YYYYMMDD'), to_date('20161021','YYYYMMDD'));
insert into SICK_PERSON values(2, 3, null, to_date('20161009','YYYYMMDD'), null);


--Well Person
insert into WELL_PERSON values(3, 4, null, to_date('20161021','YYYYMMDD'), null); 
insert into WELL_PERSON values(4, null, null, null, null); 


--Disease
insert into Disease values(1,'Heart Disease');
insert into Disease values(2, 'HIV');
insert into Disease values(3, 'COPD');


--Record Disease
insert into RECORD_DISEASE values(1, 1, '22-OCT-16');
insert into RECORD_DISEASE values(2, 2, '10-OCT-16');


--RECOMMENDATION
insert into RECOMMENDATION values(1, '7', 'Your weight', 'lbs', '120', '200', null);
insert into RECOMMENDATION values(2, '1', 'Systolic Blood Pressure', 'mmHg', '140', '159', null);
insert into RECOMMENDATION values(3, '1', 'Diastolic Blood Pressure', 'mmHg', '90', '99', null);
insert into RECOMMENDATION values(4, '7', 'Your mood', 'Happy-Neutral-Sad', null, null, 'Happy');
insert into RECOMMENDATION values(5, '1', 'Systolic Blood Pressure - No hard limits', 'mmHg', null, null, null);
insert into RECOMMENDATION values(6, '1', 'Diastolic Blood Pressure - No hard limits', 'mmHg', null, null, null);
insert into RECOMMENDATION values(7, '1', 'How painfull?', '1-10', null, null, '5');
insert into RECOMMENDATION values(8, '1', 'Your SPO2 level?', '%', '90', '99', null);
insert into RECOMMENDATION values(9, '1', 'Your temperature', 'F', '95', '100', null);
insert into RECOMMENDATION values(10, '7', 'Your weight', 'lbs', '120', '190', null);


--STANDARD_RECOMMENDATION
insert into STANDARD_RECOMMENDATION values(1, 1);
insert into STANDARD_RECOMMENDATION values(1, 2);
insert into STANDARD_RECOMMENDATION values(1, 3);
insert into STANDARD_RECOMMENDATION values(1, 4);
insert into STANDARD_RECOMMENDATION values(2, 1);
insert into STANDARD_RECOMMENDATION values(2, 5);
insert into STANDARD_RECOMMENDATION values(2, 6);
insert into STANDARD_RECOMMENDATION values(2, 7);
insert into STANDARD_RECOMMENDATION values(3, 8);
insert into STANDARD_RECOMMENDATION values(3, 9);


--Specific Recommendation
insert into SPECIFIC_RECOMMENDATION values(2, 10, localtimestamp);
insert into SPECIFIC_RECOMMENDATION values(2, 5, localtimestamp);
insert into SPECIFIC_RECOMMENDATION values(2, 6, localtimestamp);
insert into SPECIFIC_RECOMMENDATION values(2, 7, localtimestamp);
insert into SPECIFIC_RECOMMENDATION values(3, 1, localtimestamp); -- For well patient
insert into SPECIFIC_RECOMMENDATION values(4, 1, localtimestamp); -- For well patient


--Observation Type
insert into OBSERVATION_TYPE values('weight', 10); --For P2
insert into OBSERVATION_TYPE values('weight', 1); --For P1, assumed. For well patient too.
insert into OBSERVATION_TYPE values('Systolic Blood Pressure', 2); -- For P1, assumed
insert into OBSERVATION_TYPE values('Diastolic Blood Pressure', 3); -- For P1, assumed
insert into OBSERVATION_TYPE values('Mood', 4); -- For P1, assumed
insert into OBSERVATION_TYPE values('Systolic Blood Pressure', 5); -- For P2, assumed
insert into OBSERVATION_TYPE values('Diastolic Blood Pressure', 6); -- For P2, assumed
insert into OBSERVATION_TYPE values('Pain', 7); -- For P2, assumed


--Observation
--insert into OBSERVATION values(1, 'weight', '180');
--insert into OBSERVATION values(2, 'weight', '195');
--insert into OBSERVATION values(3, 'weight', '160'); -- For P1, assumed
--insert into OBSERVATION values(4, 'Systolic Blood Pressure', '165'); -- For P1, assumed. Outside the limit case
--insert into OBSERVATION values(5, 'Diastolic Blood Pressure', '96'); -- For P1, assumed
--insert into OBSERVATION values(6, 'Mood', 'Neutral'); -- For P1, assumed
--insert into OBSERVATION values(7, 'Systolic Blood Pressure', '148'); -- For P2, assumed
--insert into OBSERVATION values(8, 'Diastolic Blood Pressure', '98'); -- For P2, assumed
--insert into OBSERVATION values(9, 'Pain', '6'); -- For P2, assumed

insert into OBSERVATION values(1, 10, '180');
insert into OBSERVATION values(2, 10, '195');
insert into OBSERVATION values(3, 1, '160'); -- For P1, assumed
insert into OBSERVATION values(4, 2, '165'); -- For P1, assumed. Outside the limit case
insert into OBSERVATION values(5, 3, '96'); -- For P1, assumed
insert into OBSERVATION values(6, 4, 'Neutral'); -- For P1, assumed
insert into OBSERVATION values(7, 5, '148'); -- For P2, assumed
insert into OBSERVATION values(8, 6, '98'); -- For P2, assumed
insert into OBSERVATION values(9, 7, '6'); -- For P2, assumed
insert into OBSERVATION values(10, 1, '190'); -- For P3.  -- For well patient.
insert into OBSERVATION values(11, 1, '210'); -- For P4.  -- For well patient.


--Record Observation
insert into RECORD_OBSERVATION values(1, 2, '11-OCT-16 12.00.00 AM', '10-OCT-16 12.00.00 AM'); 
insert into RECORD_OBSERVATION values(2, 2, '17-OCT-16 12.00.00 AM', '17-OCT-16 12.00.00 AM'); 
insert into RECORD_OBSERVATION values(3, 1, '22-OCT-16','22-OCT-16'); -- For P1, assumed
insert into RECORD_OBSERVATION values(4, 1, '22-OCT-16','22-OCT-16'); -- For P1, assumed
insert into RECORD_OBSERVATION values(5, 1, '22-OCT-16','22-OCT-16'); -- For P1, assumed
insert into RECORD_OBSERVATION values(6, 1, '22-OCT-16','22-OCT-16'); -- For P1, assumed
insert into RECORD_OBSERVATION values(7, 2, '21-OCT-16','21-OCT-16'); -- For P2, assumed
insert into RECORD_OBSERVATION values(8, 2, '22-OCT-16','20-OCT-16'); -- For P2, assumed
insert into RECORD_OBSERVATION values(9, 2, '16-OCT-16', '16-OCT-16'); -- For P2, assumed. Less frequent than one per day
insert into RECORD_OBSERVATION values(10, 3, '22-OCT-16', '10-OCT-16');
insert into RECORD_OBSERVATION values(11, 4, '21-OCT-16', '14-OCT-16');
insert into RECORD_OBSERVATION values(12, 4, '21-OCT-16', '19-OCT-16');

 
commit;





