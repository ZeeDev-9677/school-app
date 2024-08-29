SELECT * FROM my_school.course;

ALTER TABLE my_school.course ADD COLUMN dateTime date;
ALTER TABLE my_school.course DROP COLUMN date_time;
ALTER TABLE my_school.course RENAME COLUMN fk_sid TO stid; -- colum name change query first ->old col and second-> new col name
ALTER TABLE my_school.course DROP COLUMN stid; -- dropping column



-----------------------

{"crId":"",
  "description": "jsd",
  "title": "hg"
//   "studentDto": [
//     {
//       "studId": "",
//       "firstName": "sj",
//       "lastName": "hfdh",
//       "rfId":""
//     },
//     {
//       "studId": "",
//       "firstName": "ht",
//       "lastName": "mm",
//       "rfId":""
//     }
//   ]
}