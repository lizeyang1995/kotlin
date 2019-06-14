package com.flong.kotlin.modules.entity

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableLogic;
import java.io.Serializable
import java.util.Date
import com.alibaba.fastjson.annotation.JSONField
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
/**
 *data保持数据data class就是一个类中只包含一些数据字段，类似于vo,pojo,java bean。一般而言，
 *我们在Java中定义了这个数据类之后要重写一下toString，equals等方法。要生成get,set方法
 *https://www.cnblogs.com/liuliqianxiao/p/7152773.html
 *注意mybatis查询数据，然后封装实体的时候，构造方法这里有点儿坑，查询的字段必须与构造方法一直。
 * 
 * @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改 
 * value–字段说明 
 * name–重写属性名字 
 * dataType–重写属性类型 
 * required–是否必填 
 * example–举例说明
 * hidden–隐藏
 * notes用于提示内容 
 */
@TableName("t_user")
@ApiModel(value = "用户对象", description = "用户对象")
data class User constructor(
	
	@TableId(value = "user_id", type = IdType.ID_WORKER)
	@ApiModelProperty(value = "用户Id",notes = "用户Id")
	var userId: Long?= null,//用户Id主键,IdWork生成
	
	@ApiModelProperty(value = "用户名称",notes ="用户名称")
	var userName: String? = null,//用户名
	
	
	@ApiModelProperty(value = "用户密码",notes ="用户密码")
	var passWord: String? = null,//密码
	
	@TableLogic
	@JSONField(name = "isDeleted")
	@ApiModelProperty(value = "删除状态,0-未删除,1-已删除",notes ="删除状态,0-未删除,1-已删除")
	var isDeleted: Int? = null,//删除
	
	@ApiModelProperty(value = "创建时间",notes ="创建时间")
	var createTime: Date? = null //创建时间,允许为空,让数据库自动生成即可


  ) :Serializable{
 
	//手动重写toString方法
	override fun toString(): String {
		return "[User(userId = $userId,userName = $userName, passWord=$passWord,isDeleted=$isDeleted,createTime=$createTime),]"
	}

	//equals
	override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as User
        if (userId != other.userId) return false
        if (userName != other.userName) return false
		if (passWord != other.passWord) return false
		if (isDeleted != other.isDeleted) return false
		if (createTime != other.createTime) return false
        return true
    }
	override fun hashCode(): Int {
		
        var result = userId?.hashCode() ?: 0
        result = 31 * result + (userName?.hashCode() ?: 0)
        result = 31 * result + (passWord?.hashCode() ?: 0)
        result = 31 * result + (isDeleted?.hashCode() ?: 0)
        result = 31 * result + (createTime?.hashCode() ?: 0)
        
        return result
    }

}

