// 评论数据
import api from '@/util/request.js'
import moment from 'moment'

export default{
    namespaced:true,
    state:{
        contents:[],
        comment:'',
        like:'https://picture.jacksonlan.top/pictures/like.png',
        liked:'https://picture.jacksonlan.top/pictures/like-fill.png',
        dislike:'https://picture.jacksonlan.top/pictures/unlike.png',
        disliked:'https://picture.jacksonlan.top/pictures/unlike-fill.png',
        time:moment(new Date()).format("yyyy-MM-DD HH:mm:ss")
    },
    mutations:{
        GetComments(state){
            let url="getComments"
            api.get(url).then(res=>{
                if(res.data.code===200){
                    state.contents=res.data.data
                }else{
                    alert("获取数据失败!")
                }
            })
        },
        Like(state,id){
            if(state.contents[id].action===null||state.contents[id].action==='disliked'){
                if(state.contents[id].action==='disliked'){
                    state.contents[id].dislike--
                }
                state.contents[id].action='liked'
                state.contents[id].like++
            }else{
                state.contents[id].action=null
                state.contents[id].like--
            }
        },
        Dislike(state,id){
            if(state.contents[id].action===null||state.contents[id].action==='liked'){
                if(state.contents[id].action==='liked'){
                    state.contents[id].like--
                }
                state.contents[id].action='disliked'
                state.contents[id].dislike++
            }else{
                state.contents[id].action=null
                state.contents[id].dislike--
            }
        },
        Submit(state){
            let url="/sendComment"
            let params={
                uid:sessionStorage.getItem("uid"),
                time:state.time,
                content:state.comment
            }
            console.log(params.time);
            api.get(url,params).then(res=>{
                if(res.data.code=200){
                    alert("评论发布成功!")
                }else{
                    alert("评论发布失败!")
                }
            })
            state.comment=''
        }
    }
}