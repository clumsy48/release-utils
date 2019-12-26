#!/usr/bin/expect -f
set privatekeyloc [lindex $argv 0];
set passphrasefile [lindex $argv 1];
set filepointer [open "${passphrasefile}" r]
set passphrase [read $filepointer]
set timeout 10
spawn ssh-add $privatekeyloc
expect "Enter passphrase for ${privatekeyloc}: "
sleep 1
send -- $passphrase\n
close $filepointer
expect -re {(?n)^Identity.*}