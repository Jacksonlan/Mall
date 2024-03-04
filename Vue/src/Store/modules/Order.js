// 订单数据信息
import api from '@/util/request.js'

export default{
    namespaced:true,
    state:{
        lis:[
            {
                name:"订单详情"
            },
            {
                name:"商品数量"
            },
            {
                name:"交易时间"
            },
            {
                name:"店铺名称"
            },
            {
                name:"交易金额"
            },
            {
                name:"交易状态"
            },
        ],
        orders:[]
    },
    mutations:{
        getData(state,od){
            if(state.orders.length==0){
                state.orders=od
            }
        }
    },
    actions:{
        Data(state){
            let url="/getOrder"
            let params={uid:sessionStorage.getItem("uid")}
            api.get(url,params).then(res=>{
                if(res.data.code===200){
                    state.commit("getData",res.data.data)
                }else{
                    alert("获取数据失败!")
                }
            })
        }
    }
}