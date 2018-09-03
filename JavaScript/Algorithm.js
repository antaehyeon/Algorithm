const readline=require("readline");

const rl=readline.createInterface({
  input:process.stdin,
  output:process.stdout
});

rl.setPrompt("## ");

rl.prompt();
rl.on("line",(data)=>{
  console.log(data);
  rl.prompt();
});