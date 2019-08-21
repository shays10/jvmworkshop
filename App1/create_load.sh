for i in $(seq 1 10000)
do
   DIFF=$((10-1+1)) #Randomize numbers between 0 and 9
   R=$(($(($RANDOM%$DIFF))+X))
   curl http://localhost:8080?contactId=$R > /dev/null
done
