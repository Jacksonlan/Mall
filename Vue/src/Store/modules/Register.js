export default{
    namespaced:true,
    state:{
            account:"",
            password:"",
            repassword:"",
            tip1:"",
            tip2:"",
            tip3:"",
            passed:false
    },
    mutations:{
        check_account(state){
            const ac=state.account
            if(ac==""||ac==null){
                state.tip1="注册账号不能为空!"
            }else{
                state.tip1=''
            }
        },
        check_password(state){
            const ps=state.password
            if(ps==""||ps==null){
                state.tip2="密码不能为空!"
            }else if(ps.length<6){
                state.tip2="密码长度不能小于6位"
            }else{
                state.tip2=''
            }
        },
        check_repassword(state){
            const reps=state.repassword
            const ps=state.password
            if(reps!=ps || reps==""){
                state.tip3="两次输入的密码不一致!"
            }else{
                state.tip3=''
            }
        },
        pass(state){
            if(state.tip1===''&& state.tip2===''&& state.tip3===''){
                state.passed=true
            }
        },
        Clear(state){
            state.account=''
            state.password=''
            state.repassword=''
        }
    }
}