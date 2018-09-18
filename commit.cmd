@echo off
cd %~dp0
git add *
git commit
git push -u origin master
pause