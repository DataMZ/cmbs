@echo off
cd %~dp0
git add *
git commit -m "msg"
git remote add origin https://github.com/DataMZ/cmbs
git push -u origin master
pause