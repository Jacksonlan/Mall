// 顶部导航数据仓库
import api from "@/util/request.js"
export default{
    namespaced:true,
    state:{
            titles: [
                {
                    name: '我的订单',
                    router: '/Order'
                },
                {
                    name: '购物车',
                    router: '/Shopping'
                },
                {
                    name: '收货地址',
                    router: '/Address',
                }
                ],
            Name:undefined,
            uid:''
    },
    mutations:{
        quit(state){
            sessionStorage.clear()
            localStorage.clear()
            state.Name=undefined
            alert('退出登录成功！')
        },
        SetName(state){
            state.Name=undefined
        },
        SetSession(state){
            if(sessionStorage.getItem("username")&&sessionStorage.getItem("uid")){
                state.Name=sessionStorage.getItem("username")
                state.uid=sessionStorage.getItem("uid")
            }
        }
    },
    actions:{
        Delete(state){ 
        const  url="/deleteUser"
        const  params={uid:sessionStorage.getItem("uid")}
        return api.get(url,params).then(res=>{
                console.log(res.data.data);
                alert("感谢您的使用，欢迎再次注册!")
                state.commit("SetName")
            }).catch((err)=>{
                console.log(err);
            })
        }
    }
}