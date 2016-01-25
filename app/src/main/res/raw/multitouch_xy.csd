<CsoundSynthesizer>
<CsOptions>
-o dac -d -b512 -B2048
</CsOptions>
<CsInstruments>
nchnls=2
0dbfs=1
ksmps=32
sr = 44100

ga1 init 0

instr 1

itie tival
i_instanceNum = p4
S_xName sprintf "touch.%d.x", i_instanceNum
S_yName sprintf "touch.%d.y", i_instanceNum

kx chnget S_xName
ky chnget S_yName

kenv linsegr 0, .001, 1, .1, 1, .25, 0
;a1 vco2 ky * 0.5 * kenv, 80 + (log(1 - kx) * 3000), 0
a1 oscil3 1.2, 110*(2+kx+ky) , 1

ga1 = ga1 + a1

endin

instr 2
;---------------Added later
;itie tival
;i_instanceNum = p4
;
;S_xName sprintf "touch.%d.x", i_instanceNum
;kx chnget S_xName
;;-----------------------------
;kcutoff chnget "cutoff"
;kresonance chnget "resonance"

kcutoff = 6000
kresonance = .1


a1 moogladder ga1, kcutoff, kresonance


;a1 delay ga1 .25
;oscil3 1.5  , 220*(1+
aL, aR reverbsc a1, a1, .3, 2000

;aL vdelay3 a1+aR*10 ,20, 100
;aR vdelay3 a1+aL*10, 20, 100


outs aL, aR

ga1 = 0

endin


</CsInstruments>
<CsScore>
f 1 0 16384 10 1

i 2 0 360000

</CsScore>
</CsoundSynthesizer>

