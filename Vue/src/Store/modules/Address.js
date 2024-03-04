// 收货地址数据
import api from "@/util/request.js"
export default{
    namespaced:true,
    state:{
            data:[],
            IsDefault:'',
            DefaultAddress:'',
            submit:''
    },
    mutations:{
        SetDefault(state,aid){
            const url="/updateDefaultAddress"
            const data={
                uid:sessionStorage.getItem("uid"),
                default_address:aid
            }
            api.get(url,data).then(res=>{
                if(res.data.code===200){
                   this.commit("Address/GetDefaultAddress")
                }
            })
        },
        GetData(state){
            const url="/getAddress"
            const params={uid:sessionStorage.getItem("uid")}
                return api.get(url,params).then(res=>{
                    if(res.data.code===200){
                        state.data=res.data.data
                    }else{
                        alert("数据获取失败!")
                    }
                })
        },
        GetDefaultAddress(state){
            const url="/getDefaultAddress"
            const params={uid:sessionStorage.getItem("uid")}
                return api.get(url,params).then(res=>{
                    if(res.data.code===200){
                        state.IsDefault=res.data.data.address_id
                        state.DefaultAddress=res.data.data.area+res.data.data.detail
                    }else{
                        alert("获取默认地址失败!")
                    }
                })
        }
    }
}