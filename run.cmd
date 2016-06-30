
:: cleanup
del /q logs\*.*
del /q logs\2016-06\*.*
del /q logs\2016-07\*.*
del /q logs\2016-08\*.*
del /q registry.*

curl -XDELETE http://ul-rvl-pr-ela01.ul.ca:9200/ul-dbg-filebeat-*

:: run filebeat
start filebeat.exe -c filebeat.windows.yml -e -v 
::start filebeat.exe -c filebeat.windows.yml -e  -d "*"

:: start generator
cd generator-bin
start run.cmd
cd ..

