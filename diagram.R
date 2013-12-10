drawPlot <- function(table, column, lengend_left ,lengend_top){
  table1Nm = paste(table, "A", sep="");
  table2Nm = paste(table, "B", sep="")
  table1 = get(table1Nm)
  table2 = get(table2Nm)
  y1 = get(column,table1)
  y2 = get(column,table2)
  
  x_range <- range(0, table1$times, table2$times)
  y_range <- range(0, y1, y2)
  plot(x=table1$times, y=y1, xlab="times", ylab=column, col="blue", type="l",lty=1, xlim=x_range, ylim=y_range)
  lines(x=table2$times, y=y2, col="red", lty=1)

  x_lengend = max(x_range) * ifelse(lengend_left, 0, 0.7)
  y_lengend = ifelse(max(y_range) == 0, 1,max(y_range)) * ifelse(lengend_top, 1, 0.2)
  legend(x=x_lengend ,y= y_lengend, legend=c("Setup A","Setup B"), col=c("blue","red"),lty=1)
  title(main=paste(table, column, sep=" of "), col.main="red", font.main=4)
}

drawAverage <- function(column, lengend_left, lengend_top){
	drawPlot(table="Average",column, lengend_left, lengend_top)
}

drawDerivation <- function(column, lengend_left, lengend_top){
	drawPlot(table="StandardDeviation", column, lengend_left, lengend_top)
}

AverageA <- read.table("D:/NC_Files/Setup A/out/average", header=T, sep="\t") 
AverageB <- read.table("D:/NC_Files/Setup B/out/average", header=T, sep="\t")
StandardDeviationA <- read.table("D:/NC_Files/Setup A/out/sd", header=T, sep="\t")
StandardDeviationB <- read.table("D:/NC_Files/Setup B/out/sd", header=T, sep="\t")

pdf('C:/Users/Administrator/Desktop/NC_Computing.pdf', width = 8.3, height = 11.7)
par(omi = rep(.5, 4))
par(mfrow = c(3,2))

drawAverage("bestFitness",F,T)
drawAverage("averageFitness",F,T)
drawAverage("averageUsedGeneLength",F,F)
drawAverage("time",F,T)
drawAverage("invalids",F,T)
drawAverage("varFitness",F,T)
drawAverage("aveLength",F,F)
drawAverage("aveDerivationTreeDepth",F,F)
drawAverage("SlopeMutRate",T,T)

drawDerivation("bestFitness",F,T)
drawDerivation("averageFitness",F,T)
drawDerivation("averageUsedGeneLength",F,F)
drawDerivation("time",F,T)
drawDerivation("invalids",F,T)
drawDerivation("varFitness",F,T)
drawDerivation("aveLength",F,T)
drawDerivation("aveDerivationTreeDepth",F,F)
drawDerivation("SlopeMutRate",T,T)

dev.off()