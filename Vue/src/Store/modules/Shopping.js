// 购物车数据
import api from '@/util/request.js'
export default{
    namespaced:true,
    state:{
        goods:[],
        sum:0
    },
    mutations:{
        GetCar(state){
            let url="/getCar"
            let params={uid:sessionStorage.getItem("uid")}
            api.get(url,params).then(res=>{
                if(res.data.code===200){
                    state.goods=res.data.data
                }else{
                    alert("获取数据失败!")
                }
            })
        },
        su(state,i){
            if(state.goods[i].current_count>1){
                state.goods[i].current_count--
            }
        },
        ad(state,i){
            if(state.goods[i].current_count<state.goods[i].stock){
                state.goods[i].current_count++
            }
        }
    }
}