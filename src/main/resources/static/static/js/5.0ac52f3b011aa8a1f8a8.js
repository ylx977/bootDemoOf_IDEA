webpackJsonp([5],{B8E0:function(e,t){},NZY8:function(e,t){},"R+8f":function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=s("bOdI"),a=s.n(o),i=s("CaOM"),r={data:function(){return{sels:[],roleShow:!1,giveRole:[],allRole:[],checkList:[],customerId:"",updateUserInfoData:{},addCustomerShow:!1,addCustomer:{username:"",password:"",contact:"",personName:""},rulesLogin:{username:[{required:!0,validator:function(e,t,s){if(!/^[0-9a-zA-Z]{5,20}$/g.test(t))return s(new Error("5-20位字母数字"));s()},trigger:"blur"}],password:[{required:!0,validator:function(e,t,s){return t?t.length<5?s(new Error("密码至少5位")):t.length>20?s(new Error("密码至多20位")):void s():s(new Error("请输入密码"))},trigger:"blur"}],contact:[{required:!0,validator:function(e,t,s){return t?/(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/.test(t)?void s():s(new Error("输入的手机格式不正确")):s(new Error("请输入手机号"))},trigger:"blur"}],personName:[{required:!0,validator:function(e,t,s){if(!t)return s("请输入姓名");s()},trigger:"blur"}]},total:0,limitDate:{uid:"",password:"",username:"",contact:"",personName:""},userForm:{},formLabelWidth:"120",userLoading:!1,limit:!1,userList:[],userInfoData:{page:1,rowNum:"10",startTime:"",endTime:""}}},methods:a()({open:function(e){var t=this;this.$confirm("此操作将永久删除一批客服, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.$message({type:"success",message:"删除成功!",callback:e()})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},selsChange:function(e){this.sels=e,console.log("这是sels"),console.log(e)},delGroup:function(){for(var e=this,t=[],s=0;s<this.sels.length;s++)t.push(this.sels[s].uid);console.log("这是uids"),console.log(t);var o={uids:t};Object(i.a)(this,this.ApiConfig.userManagement.users.deleteUsers,o,function(t){if(200!=t.code)return e.$notify({title:"提示",message:t.message,type:"warning"}),!1;console.log(t),e.getUserInfo()},"POST")},handleCurrentChange:function(e,t,s){this.$refs.table.toggleRowSelection(e)},isChecked:function(){alert("wawa ")},getUserInfo:function(){var e=this;Object(i.a)(this,this.ApiConfig.userManagement.users.queryUserInfo,this.userInfoData,function(t){if(200!=t.code)return e.$notify({title:"提示",message:t.message,type:"warning"}),!1;console.log(t),e.userList=t.data.rows,e.total=t.data.total},"POST")},createUser:function(){var e=this;this.$refs.addCustomer.validate(function(t){if(!t)return!1;Object(i.a)(e,e.ApiConfig.userManagement.users.createUser,e.addCustomer,function(t){if(200!=t.code)return e.$notify({title:"提示",message:t.message,type:"warning"}),!1;e.addCustomerShow=!1,console.log(t),e.addCustomer.username="",e.addCustomer.password="",e.addCustomer.contact="",e.addCustomer.personName="",e.getUserInfo()},"POST")})},open2:function(e,t){var s=this;this.$confirm("此操作将永久删除该客服, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){s.deleteUsers(e,t),s.$message({type:"success",message:"删除成功!"})}).catch(function(){s.$message({type:"info",message:"已取消删除"})})},deleteUsers:function(e,t){var s=this,o=[];o.push(t.uid);var a={uids:o};Object(i.a)(this,this.ApiConfig.userManagement.users.deleteUsers,a,function(e){if(200!=e.code)return s.$notify({title:"提示",message:e.message,type:"warning"}),!1;console.log(e),s.getUserInfo()},"POST")},updateUserInfo:function(e,t){this.limit=!0,this.limitDate.uid=t.uid,this.limitDate.username=t.username,this.limitDate.password=t.password,this.limitDate.contact=t.contact,this.limitDate.personName=t.personName},updateUserInfoTrue:function(){var e=this;this.$refs.limitDate.validate(function(t){if(!t)return!1;Object(i.a)(e,e.ApiConfig.userManagement.users.updateUserInfo,e.limitDate,function(t){if(200!=t.code)return e.$notify({title:"提示",message:t.message,type:"warning"}),!1;console.log(t),e.limit=!1,e.getUserInfo()},"POST")})},showRoleInfoUnderUser:function(e,t){var s=this;this.giveRole=[];var o={uid:t.uid};this.customerId=t.uid,Object(i.a)(this,this.ApiConfig.userManagement.users.showRoleInfoUnderUser,o,function(e){if(200!=e.code)return s.$notify({title:"提示",message:e.message,type:"warning"}),!1;console.log(e),s.allRole=e.data,s.roleShow=!0,console.log(s.allRole),s.allRole.forEach(function(e,t,o){1==s.allRole[t].isSelected&&s.giveRole.push(s.allRole[t].authgroupId)})},"POST")},changeFun:function(e){0==e.isSelected?e.isSelected=1:e.isSelected=0,console.log(e.authgroupId),1==e.authgroupId?this.allRole[0]=e:2==e.authgroupId?this.allRole[1]=e:this.allRole[e.authgroupId]=e},assignRoles4User:function(){var e=this;this.checkList=[],console.log(this.checkList+"这是前面的checkList");for(var t=0;t<this.allRole.length;t++)1==this.allRole[t].isSelected&&this.checkList.push(this.allRole[t].authgroupId);console.log(this.checkList+"这是checkList");var s={uid:this.customerId,authgroupIds:this.checkList};console.log(s.roleId),Object(i.a)(this,this.ApiConfig.userManagement.users.assignRoles4User,s,function(t){if(200!=t.code)return e.$notify({title:"提示",message:t.message,type:"warning"}),!1;console.log(t),e.$notify({title:"提示",message:t.message,type:"success"}),e.roleShow=!1},"POST")},tableRowClassName:function(e){e.row;if(e.rowIndex%2==1)return"success-row"}},"handleCurrentChange",function(e){this.acountDate.page=e,this.queryFrontUserAccount()}),mounted:function(){this.getUserInfo()}},n={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("section",{attrs:{id:"customer"}},[s("span",{staticClass:"title"},[e._v(e._s(e.$t("service.service")))]),e._v(" "),s("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[s("el-form",{attrs:{inline:!0,model:e.userForm}},[s("el-form-item",[s("el-button",{staticClass:"info",attrs:{disabled:0===e.sels.length},on:{click:function(t){e.open(e.delGroup)}}},[e._v(e._s(e.$t("delete")))])],1),e._v(" "),s("el-form-item",[s("el-button",{staticClass:"warning",on:{click:function(t){e.addCustomerShow=!0}}},[e._v(e._s(e.$t("newAdd")))])],1)],1)],1),e._v(" "),s("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.userLoading,expression:"userLoading"}],staticStyle:{width:"aotu"},attrs:{data:e.userList,"row-class-name":e.tableRowClassName},on:{"selection-change":e.selsChange}},[s("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),s("el-table-column",{attrs:{type:"index",width:"50"}}),e._v(" "),s("el-table-column",{attrs:{prop:"uid",label:e.$t("service.thead[1]")}}),e._v(" "),s("el-table-column",{attrs:{prop:"personName",label:e.$t("service.thead[2]")}}),e._v(" "),s("el-table-column",{attrs:{prop:"contact",label:e.$t("service.thead[3]")}}),e._v(" "),s("el-table-column",{attrs:{label:e.$t("service.thead[4]")},scopedSlots:e._u([{key:"default",fn:function(t){return[s("el-button",{attrs:{size:"mini"},on:{click:function(s){e.showRoleInfoUnderUser(t.$index,t.row)}}},[e._v(e._s(e.$t("allot")))])]}}])}),e._v(" "),s("el-table-column",{attrs:{label:e.$t("service.thead[5]")},scopedSlots:e._u([{key:"default",fn:function(t){return[s("el-button",{attrs:{size:"mini"},on:{click:function(s){e.updateUserInfo(t.$index,t.row)}}},[e._v(e._s(e.$t("xiuGai")))]),e._v(" "),s("el-button",{attrs:{type:"text"},on:{click:function(s){e.open2(t.$index,t.row)}}},[e._v(e._s(e.$t("delete")))])]}}])})],1),e._v(" "),s("el-dialog",{attrs:{title:e.$t("newCustomerServicer"),visible:e.addCustomerShow,id:"addKeHu",center:""},on:{"update:visible":function(t){e.addCustomerShow=t}}},[s("el-form",{ref:"addCustomer",attrs:{model:e.addCustomer,rules:e.rulesLogin}},[s("el-form-item",{attrs:{label:e.$t("Identification"),prop:"username","label-width":e.formLabelWidth}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addCustomer.username,callback:function(t){e.$set(e.addCustomer,"username",t)},expression:"addCustomer.username"}})],1),e._v(" "),s("el-form-item",{attrs:{label:e.$t("passWord"),prop:"password","label-width":e.formLabelWidth}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addCustomer.password,callback:function(t){e.$set(e.addCustomer,"password",t)},expression:"addCustomer.password"}})],1),e._v(" "),s("el-form-item",{attrs:{label:e.$t("service.thead[3]"),prop:"contact","label-width":e.formLabelWidth}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addCustomer.contact,callback:function(t){e.$set(e.addCustomer,"contact",t)},expression:"addCustomer.contact"}})],1),e._v(" "),s("el-form-item",{attrs:{label:e.$t("service.thead[2]"),prop:"personName","label-width":e.formLabelWidth}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addCustomer.personName,callback:function(t){e.$set(e.addCustomer,"personName",t)},expression:"addCustomer.personName"}})],1)],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{staticClass:"exit",on:{click:function(t){e.addCustomerShow=!1}}},[e._v(e._s(e.$t("cancel")))]),e._v(" "),s("el-button",{staticClass:"sureSure",attrs:{type:"primary"},on:{click:e.createUser}},[e._v(e._s(e.$t("confirm")))])],1)],1),e._v(" "),s("el-dialog",{attrs:{title:e.$t("roleAssignment"),visible:e.roleShow,id:"roleFenPei"},on:{"update:visible":function(t){e.roleShow=t}}},[s("el-checkbox-group",{model:{value:e.giveRole,callback:function(t){e.giveRole=t},expression:"giveRole"}},[e._l(e.allRole,function(t,o){return[s("el-checkbox",{key:o,attrs:{label:t.authgroupId},on:{change:function(s){e.changeFun(t)}}},[e._v(e._s(t.authgroupName))])]})],2),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{staticClass:"exit",on:{click:function(t){e.roleShow=!1}}},[e._v(e._s(e.$t("cancel")))]),e._v(" "),s("el-button",{staticClass:"sureSure",attrs:{type:"primary"},on:{click:e.assignRoles4User}},[e._v(e._s(e.$t("confirm")))])],1)],1),e._v(" "),s("el-dialog",{attrs:{title:e.$t("power"),visible:e.limit,id:"powerFrom"},on:{"update:visible":function(t){e.limit=t}}},[s("el-form",{ref:"limitDate",attrs:{model:e.limitDate,rules:e.rulesLogin}},[s("el-form-item",{attrs:{label:e.$t("Identification"),"label-width":e.formLabelWidth,prop:"username"}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.limitDate.username,callback:function(t){e.$set(e.limitDate,"username",t)},expression:"limitDate.username"}})],1),e._v(" "),s("el-form-item",{attrs:{label:e.$t("passWord"),"label-width":e.formLabelWidth,prop:"password"}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.limitDate.password,callback:function(t){e.$set(e.limitDate,"password",t)},expression:"limitDate.password"}})],1),e._v(" "),s("el-form-item",{attrs:{label:e.$t("service.thead[3]"),"label-width":e.formLabelWidth,prop:"contact"}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.limitDate.contact,callback:function(t){e.$set(e.limitDate,"contact",t)},expression:"limitDate.contact"}})],1),e._v(" "),s("el-form-item",{attrs:{label:e.$t("service.thead[2]"),"label-width":e.formLabelWidth,prop:"personName"}},[s("el-input",{attrs:{"auto-complete":"off"},model:{value:e.limitDate.personName,callback:function(t){e.$set(e.limitDate,"personName",t)},expression:"limitDate.personName"}})],1)],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{staticClass:"exit",on:{click:function(t){e.limit=!1}}},[e._v(e._s(e.$t("cancel")))]),e._v(" "),s("el-button",{staticClass:"sureSure",attrs:{type:"primary"},on:{click:e.updateUserInfoTrue}},[e._v(e._s(e.$t("confirm")))])],1)],1),e._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:e.total>10,expression:"total >10"}],staticClass:"page"},[s("el-col",{staticClass:"toolbar  ",attrs:{span:24}},[s("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:e.total},on:{"current-change":e.handleCurrentChange}})],1)],1)],1)},staticRenderFns:[]};var l=s("VU/8")(r,n,!1,function(e){s("B8E0"),s("NZY8")},"data-v-afb116d0",null);t.default=l.exports}});
//# sourceMappingURL=5.0ac52f3b011aa8a1f8a8.js.map