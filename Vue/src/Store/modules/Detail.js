// 商品详情数据
import api from '@/util/request'

export default{
    namespaced:true,
    state:{
        detail:[]
    },
    mutations:{
        GetDetail(state,id){
            let url="/getDetail"
            let params={good_id:id}
            api.get(url,params).then(res=>{
                if(res.data.code===200){
                    state.detail=res.data.data
                }else{
                    alert("获取数据失败!")
                }
            })
        }
    }
}