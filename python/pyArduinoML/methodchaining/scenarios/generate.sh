#!/bin/bash

declare -a arr=("beep_alarm.py" "dual_check_alarm.py" "multi_state_alarm.py" "remote_alarm.py" "state_based_alarm.py" "temporal_alarm.py" "very_simple_alarm.py")

for i in "${arr[@]}"
do
  py.exe $i
done