CREATE TABLE `T_superAdmin` (
`Id` int NOT NULL AUTO_INCREMENT,
`username` varchar(20) NOT NULL,
`password` varchar(20) NOT NULL,
`name` varchar(20) NULL,
`flag` int NOT NULL,
PRIMARY KEY (`Id`) 
);

CREATE TABLE `T_admin` (
`Id` int NOT NULL AUTO_INCREMENT,
`username` varchar(20) NOT NULL,
`password` varchar(20) NOT NULL,
`name` varchar(20) NOT NULL,
`flag` int NOT NULL,
`introduction` varchar(100) NULL,
PRIMARY KEY (`Id`) 
);

CREATE TABLE `T_orderIn` (
`Id` int UNSIGNED NOT NULL AUTO_INCREMENT,
`docu_number` char(15) NOT NULL,
`warehouseId` int NOT NULL,
`in_time` date NOT NULL,
`manager` int NOT NULL,
`source` varchar(50) CHARACTER SET utf8 NOT NULL,
`flag` int NOT NULL,
PRIMARY KEY (`Id`) 
);

CREATE TABLE `T_orderOut` (
`Id` int NOT NULL AUTO_INCREMENT,
`d_number` char(15) NOT NULL,
`warehouse` int NOT NULL,
`out_time` date NOT NULL,
`manager` int NOT NULL,
`send` varchar(50) NOT NULL COMMENT '发往地',
`fla` int NOT NULL,
PRIMARY KEY (`Id`) 
);

CREATE TABLE `T_wareHouse` (
`Id` int NOT NULL AUTO_INCREMENT,
`docu_number` char(5) NOT NULL,
`contact_phone` char(20) NOT NULL,
`name` varchar(50) NOT NULL,
`contact` varchar(20) NOT NULL,
`total_storage` int NOT NULL,
`flag` int NOT NULL,
PRIMARY KEY (`Id`) 
);

CREATE TABLE `T_clothes` (
`Id` int NOT NULL AUTO_INCREMENT,
`docu_number` char(6) NOT NULL,
`color` varchar(14) NOT NULL,
`size` int NOT NULL,
`commodity_name` varchar(14) NOT NULL,
`ex_factory_price` int NOT NULL,
`operator` int NOT NULL,
`retail_price` int NOT NULL,
`out_material` varchar(20) NOT NULL COMMENT '外料',
`in_material` varchar(20) NOT NULL COMMENT '里料',
`flag` int NOT NULL,
PRIMARY KEY (`Id`) 
);

CREATE TABLE `T_stage` (
`Id` int NOT NULL,
`clothes_id` int NOT NULL,
`stage_number` int NOT NULL,
PRIMARY KEY (`Id`) 
);

CREATE TABLE `T_log` (
`log` varchar(50) NOT NULL,
`Id` int NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`Id`) 
);


ALTER TABLE `T_orderIn` ADD CONSTRAINT `fk_OrderIn_Admin_1` FOREIGN KEY (`manager`) REFERENCES `T_admin` (`Id`);
ALTER TABLE `T_orderIn` ADD CONSTRAINT `fk_T_orderIn_T_wareHouse_1` FOREIGN KEY (`warehouseId`) REFERENCES `T_wareHouse` (`Id`);
ALTER TABLE `T_clothes` ADD CONSTRAINT `fk_T_clothes_T_admin_1` FOREIGN KEY (`operator`) REFERENCES `T_admin` (`Id`);
ALTER TABLE `T_stage` ADD CONSTRAINT `fk_T_stage_T_wareHouse_1` FOREIGN KEY (`Id`) REFERENCES `T_wareHouse` (`Id`);
ALTER TABLE `T_stage` ADD CONSTRAINT `fk_T_stage_T_clothes_1` FOREIGN KEY (`clothes_id`) REFERENCES `T_clothes` (`Id`);
ALTER TABLE `T_orderOut` ADD CONSTRAINT `fk_T_orderOut_T_admin_1` FOREIGN KEY (`manager`) REFERENCES `T_admin` (`Id`);

