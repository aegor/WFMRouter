﻿# curl -X POST "http://w10:8080/PlanDelete" -H "accept: */*" -H "Content-Type: application/json" -d "{\"RequestId\":0,\"EmployeeId1C\":\"string\",\"EmployeeSourceId\":0,\"Year\":0,\"Month\":0}"
curl -v -X POST --user admin:admin -H 'accept: */*' -H 'Content-Type: application/json' -d '{"EmployeeId1C": "864f2f86-ed72-11e8-abde-00155d306a32", "ActionType": 4, "EventType": 8, "Actual": 1, "DayTypeId": "06", "DateStart": "04.09.2019", "DateEnd": "05.09.2019", "DocumentId": "2edac7d9-cecc-11e9-90a5-00155d306a3d", "RowNumber": 1}' http://127.0.0.1:8080/GetRequestFrom1C