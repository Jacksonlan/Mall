// 商品首页数据
import api from '@/util/request.js'

export default{
    namespaced:true,
    state:{
            goods:[],
            imgList:[
                {
                    src:'https://picture.jacksonlan.top/pictures/1.jpg'
                },
                {
                    src:'https://picture.jacksonlan.top/pictures/2.jpg'
                },
                {
                    src:'https://picture.jacksonlan.top/pictures/3.jpg'
                }
            ],
            n:0,
            pause:null
    },
    mutations:{
        GetAllMessage(state){
            let url="/getGoods"
            api.get(url).then(res=>{
                if(res.data.code===200){
                    state.goods=res.data.data
                }else{
                    alert("获取数据失败!")
                }
            })
        },
        Roll(state){
            state.pause=setInterval(()=>{
                state.n++;
                if(state.n==state.imgList.length){
                    state.n=0;
                }
            },3000)
        },
        Pause(state){
            clearInterval(state.pause)
        },
        silde(state,str){
            if(str==="back"){
                if(state.n==0){
                    state.n=state.imgList.length
                }
                state.n--;
            }else if(str=="next"){
                state.n++;
                if(state.n==state.imgList.length){
                    state.n=0
                }
            }
        },
        Spot_li(state,index){
            state.n=index
        }
    }
}