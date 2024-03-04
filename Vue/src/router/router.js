import {createRouter,createWebHistory} from 'vue-router'
import Shopping from '../components/Shopping.vue'
import Order from '../components/Order.vue'
import Login from '../components/Login.vue'
import Goods_home from  '../components/Goods_home.vue'
import Goods_detail from '../components/Goods_detail.vue'
import Collection from '../components/Collection.vue'
import Register from '../components/Register.vue'
import Address from '../components/Address.vue'
import AddSuccess from '../components/AddSuccess.vue'

const router=createRouter({
    history:createWebHistory(),
    routes:[
      {
        path:'/',
        redirect:'/goods_home',
      },
      {
        path:'/Login',
        component:Login,
        name:'login',
        meta:{
          title:"登录"
        }
      },
      {
        path:'/register',
        component:Register,
        name:'register',
        meta:{
          title:"注册"
        }
      },
      {
        path:"/AddSuccess",
        component:AddSuccess,
        name:'addSuccess',
        meta:{
          title:"成功页面"
        }
      },
      // 嵌套路由父路由
      {
        path:'/Collection',
        component:Collection,
        name:'collection',
        // 子路由
        children:[
          {
            path:'/goods_home',
            component:Goods_home,
            name:'goods_home',
            meta:{
              title:"商城首页"
            }
          },
          {
            path:'/Shopping',
            component:Shopping,
            name:'shopping',
            meta:{
              title:"购物车"
            }
          },
          {
            path:'/Order',
            component:Order,
            name:'order',
            meta:{
              title:"我的订单"
            }
          },
          {
            path:'/Goods_detail',
            component:Goods_detail,
            name:'goods_detail',
            meta:{
              title:"商品详情"
            }
          },
          {
            path:'/Address',
            component:Address,
            name:'address',
            meta:{
              title:"收货地址"
            }
          }
        ]
      },
    ]
});
router.beforeEach(async (to)=>{
  if(to.meta.title){
    document.title=to.meta.title;
  }
});
export default router