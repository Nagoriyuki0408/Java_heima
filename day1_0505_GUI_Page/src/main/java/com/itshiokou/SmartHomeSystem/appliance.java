package com.itshiokou.SmartHomeSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//智能家居系统
//接口模式设计
/*整体架构：
 *类名：appliance，总的家电类，后续的家电都继承这个父类
 * 在这个父类里写入一个接口，接口里包含抽象函数open()和close_()
 * 子类名：chandelier、TV、washer、French_window
 * 功能：
 * open()：打开家电
 * close_()：关闭家电
 * 变量名：
 *
 * */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class appliance {
String name;
boolean status;
}
