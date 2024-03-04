// 登录模块数据
export default{
    namespaced:true,
    state:{
            acc:'',
            pss:'',
            message:'',
            tip:''
    },
    mutations:{
        checked_ac(state){
            if(state.acc=="" ||state.acc==null){
                state.message="请输入账号!"
            }else{
                state.message=''
            }
        },
        checked_ps(state){
            if(state.pss==""|| state.pss==null){
                state.tip="请输入密码!"
            }else if(state.pss.length<6){
                state.tip="您输入的密码不能少于6位!"
            }else{
                state.tip=''
            }
        },
        Clear(state){
            state.acc=''
            state.pss=''
        }
    }
}