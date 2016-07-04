
:: cleanup
del /q logs\*.*
del /q logs\2016-06\*.*
del /q logs\2016-07\*.*
del /q logs\2016-08\*.*
del /q registry*

curl -XDELETE http://ul-rvl-pr-ela01.ul.ca:9200/ul-dbg-filebeat-*

:: run filebeat
::start filebeat-1.2.3.exe        -c filebeat-1.2.3.yml        -e -v
start filebeat-5.0.0-alpha4.exe -c filebeat-5.0.0-alpha4.yml -e -v

:: start generator
cd generator-bin
start run.cmd
cd ..

