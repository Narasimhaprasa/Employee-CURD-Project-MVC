 function validation(frm){
	 //empty the error messages
    document.getElementById("enameErr").innerHTML="";
    document.getElementById("jobErr").innerHTML="";
    document.getElementById("salErr").innerHTML="";
// read form date
  let ename = frm.ename.value;
  let job=frm.job.value;
  let sal = frm.sal.value;
let flag =true;
 //form validation (client side)
 if(ename==""){
	document.getElementById("enameErr").innerHTML="employee name is mandatory(cs)";
	flag=false;
  }//if
else if(ename.length>10){
	document.getElementById("enameErr").innerHTML="employee name must be have max 10 characters(cs)";
	flag=false;
}//else if

//job required rule
if(job==""){
	document.getElementById("jobErr").innerHTML="employee desg is required(cs)";
	flag=false;
}//if
else if(job.length>9){
	document.getElementById("jobErr").innerHTML="employee desg can have max of 9 characters(cs)";
	flag=false;
	}//else of
	
	//sal required
	if(sal==""){
		document.getElementById("salErr").innerHTML="employee salary is required(cs)";
		flag=false;
	}//if
	else if(isNaN(sal)){
		document.getElementById("salErr").innerHTML="Employee salary must be numeric value(cs)";
		flag=false;
	}//elseif
	else if(sal<0 || sal>100000){
		docuement.getElementById="salErr".innerHTML="employee salary must be in the range of 1 to 100000(cs)";
		flag = false;
	}//else if 
	
	// change vfalg value to yes indicating cleint side form validations are done
	frm.vflag.value="yes"
return flag;

}
	
