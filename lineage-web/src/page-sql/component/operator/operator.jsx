import React from 'react'
import {Tooltip, Menu, Dropdown} from 'antd'
import Icon, {FullscreenOutlined, DownOutlined, FullscreenExitOutlined, VerticalAlignBottomOutlined, VerticalAlignTopOutlined} from '@ant-design/icons'
import ExpandDownIcon from '../../img/expand-down.svg'
import ExpandUpIcon from '../../img/expand-up.svg'
import ExpandDownGrayIcon from '../../img/expand-down-gray.svg'
import ExpandUpGrayIcon from '../../img/expand-up-gray.svg'
import ShrinkUpIcon from '../../img/shrink-up.svg'
import ShrinkDownIcon from '../../img/shrink-down.svg'
import FoldIcon from '../../img/fold.svg'
import UnFoldIcon from '../../img/unfold.svg'
import FoldWhiteIcon from '../../img/fold-white.svg'
import UnFoldWhiteIcon from '../../img/unfold-white.svg'
import InfoWhiteIcon from '../../img/info-white.svg'
import InfoIcon from '../../img/info.svg'


import './operator.styl'

const menu = (onAction, tableId, scopeType) => (
  <Menu>
    <Menu.Item key="0">
      展开层数
    </Menu.Item>
    <Menu.Divider />
    <Menu.Item 
      key="1" 
      onClick={e => {
        e.domEvent.stopPropagation()
        onAction({action: 'expand', tableId, scopeType, level: 1})
      }}
    >
      1层
    </Menu.Item>
    <Menu.Item 
      key="2" 
      onClick={e => {
        e.domEvent.stopPropagation()
        onAction({action: 'expand', tableId, scopeType, level: 2})
      }}
    >
      2层
    </Menu.Item>
    <Menu.Item 
      key="3" 
      onClick={e => {
        e.domEvent.stopPropagation()
        onAction({action: 'expand', tableId, scopeType, level: 3})
      }}
    >
      3层
    </Menu.Item>
    <Menu.Item 
      key="4" 
      onClick={e => {
        e.domEvent.stopPropagation()
        onAction({action: 'expand', tableId, scopeType, level: 4})
      }}
    >
      4层
    </Menu.Item>
    <Menu.Item 
      key="5" 
      onClick={e => {
        e.domEvent.stopPropagation()
        onAction({action: 'expand', tableId, scopeType, level: 5})
      }}
    >
      5层
    </Menu.Item>
    {/* <Menu.Item key="3" onClick={() => onAction('expand', tableId, scopeType, 3)}>3层</Menu.Item>
    <Menu.Item key="4" onClick={() => onAction('expand', tableId, scopeType, 4)}>4层</Menu.Item>
    <Menu.Item key="5" onClick={() => onAction('expand', tableId, scopeType, 5)}>5层</Menu.Item> */}
  </Menu>
)

const getOps = ({
  isPrimary, // 是否为主表
  isFold,
  isUpExpand, // 当前节点是否有上游
  isDownExpand, // 当前节点是否有下游
  isExpand,
  scopeType, // 当前节点与主表的上下游关系 上游-1 下游-2 上下游-3
  onAction,
  tableId,
  classId,
  type,
  descr,
  name,
  loopNum = 0,
  hasDownstream,
  hasUpstream,
  tableIcon,
}) => {
  const ShrinkUp = {
    tooltip: '收起上游',
    action: 'shrink',
    scopeType: '1',
    component: <div className="shrink-up"><img alt="" src={ShrinkUpIcon} className="shrink-up-icon" /></div>,
  }
  const ShrinkDown = {
    tooltip: '收起下游',
    action: 'shrink',
    scopeType: '2',
    component: <div className="shrink-right"><img alt="" src={ShrinkDownIcon} className="shrink-down-icon" /></div>,
  }
  const ExpandUp = {
    tooltip: '展开上游',
    action: 'expand',
    scopeType: '1',
    component: 
    hasUpstream ? 
      <Dropdown 
        overlay={menu(onAction, tableId, 1)} 
        trigger={['click']} 
        getPopupContainer={() => document.getElementById('lineageArea')}
      >
        <img alt="" src={ExpandUpIcon} className="expand-up-icon" />
      </Dropdown>
      :
      <span className="disabled">
        <img alt="" src={ExpandUpGrayIcon} className="expand-up-icon" style={{transform: "rotate(180deg)"}} />
      </span>,
  }
  const ExpandDown = {
    tooltip: '展开下游',
    action: 'expand',
    scopeType: '2',
    component: hasDownstream ? 
      <Dropdown 
        overlay={menu(onAction, tableId, 2)} 
        trigger={['click']} 
        getPopupContainer={() => document.getElementById('lineageArea')}
      >
        <img alt="" src={ExpandDownIcon} className="expand-down-icon" />
      </Dropdown> 
      : 
      <span className="disabled">
        <img alt="" src={ExpandDownGrayIcon} className="expand-down-icon" />
      </span>,
  }
  const Fold = {
    tooltip: '展开字段',
    action: 'fold',
    scopeType: '',
    component: <div className="top-icon fold-icon"><img alt="" src={isPrimary ? FoldWhiteIcon : FoldIcon} /></div>,
  }
  const UnFold = {
    tooltip: '收起字段',
    action: 'unfold',
    scopeType: '',
    component: <div className="top-icon unfold-icon active"><img alt="" src={isPrimary ? UnFoldWhiteIcon : UnFoldIcon} /></div>,
  }
  const Info = {
    tooltip: '详情信息',
    action: 'info',
    scopeType: '',
    component: <div className="top-icon info-icon"><img alt="" src={isPrimary ? InfoWhiteIcon : InfoIcon} /></div>,
  }
  const opsData = [
    isUpExpand || loopNum > 0 ? {} : ExpandUp,
    isDownExpand || loopNum > 0 ? {} : ExpandDown,
    isDownExpand && loopNum === 0 && (scopeType === '2' || scopeType === '3') ? ShrinkDown : {},
    isUpExpand && loopNum === 0 && (scopeType === '1' || scopeType === '3') ? ShrinkUp : {},
    Info,
    type === 2 ? (isFold ? Fold : UnFold) : {},
  ]
  const arry = opsData
    .filter(t => Object.getOwnPropertyNames(t).length !== 0)
    .map(op => {
      return {
        component: (
          <>
            {
              op.action !== 'expand'
                ? (
                  <Tooltip 
                    title={op.tooltip}
                  >
                    <span onClick={e => {
                      e.stopPropagation()
                      onAction({action: op.action, tableId, classId, scopeType: op.scopeType, type, descr, name, tableIcon})
                    }}
                    >
                      {
                        op.component
                      }
                    </span>
                  </Tooltip>
                )
                : op.component
            }
          </>
        ),
      }
    })
  return arry
}

export default getOps
