// 弹窗数据
export default{
    namespaced:true,
    state:{
            data:[],
            other:'无',
            title:'',
            IsShow:false,
            InputTitle:[
                {
                    title:'收货人',
                    max:10
                },
                {
                    title:'地址信息',
                    max:20
                },
                {
                    title:'详细地址',
                    max:20
                },
                {
                    title:'联系电话',
                    max:11
                },
            ]
    },
    mutations:{
        // 弹窗开关
       SwitchAlert(state,t){
            state.title=t
            state.IsShow=!state.IsShow
       },
    //    清除弹窗中的数据
       Clear(state){
            state.data=[]
            state.init=false
            state.other='无'
            state.title=''
       }
    }
}