@echo off
setlocal
set btrace_path=D:\Locate\util\btrace-bin-1.3.11.2\bin\btrace.bat
set java_path=D:\git\project\selfWork\MyTest\java\simpleTest\src\main\java\com\xubao\test\simpleTest\btraceTest
set java_pid=10368
set port=11999
set name=%1

%btrace_path% -p %port% %java_pid% %java_path%/%name%.java

endlocal

@echo on